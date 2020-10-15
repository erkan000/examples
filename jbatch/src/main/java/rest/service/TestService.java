package rest.service;

import java.util.List;
import java.util.Properties;

import javax.batch.operations.JobExecutionNotRunningException;
import javax.batch.operations.JobOperator;
import javax.batch.operations.JobSecurityException;
import javax.batch.operations.NoSuchJobException;
import javax.batch.operations.NoSuchJobExecutionException;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobInstance;
import javax.batch.runtime.Metric;
import javax.batch.runtime.StepExecution;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("")
public class TestService {  

    @GET
    @Path("startChunk")
    public String startChunk() {
    	JobOperator operator = BatchRuntime.getJobOperator();
    	long executionID = operator.start("chunkJob", new Properties());
        return "Batch started with ID: " + executionID;
    }
    
    @GET
    @Path("startBatchlet")
    public String startBatchlet() {
    	JobOperator operator = BatchRuntime.getJobOperator();
    	long executionID = operator.start("batchletJob", new Properties());
    	return "Batch started with ID: " + executionID;
    }
    
    @GET
    @Path("status-running")
    public String status() {
    	String result = "look at console";
    	try {
			JobOperator operator = BatchRuntime.getJobOperator();
			List<Long> executionIdList = operator.getRunningExecutions("chunkJob");
			for (Long executionId : executionIdList) {
				System.out.println("Running execution : " + executionId);
				StepExecution stepExecution = operator.getStepExecutions(executionId).get(0);
				System.out.println(stepExecution.getBatchStatus());
				System.out.println(stepExecution.getStepName());
				System.out.println(stepExecution.getPersistentUserData());
				Metric[] met = stepExecution.getMetrics();
				for (Metric m : met) { 
					System.out.println(m.getType() + "\t" + m.getValue());
				}				
			}
		} catch (NoSuchJobException | JobExecutionNotRunningException | NoSuchJobExecutionException e) {
			result = "No running jobs";
		} catch (JobSecurityException e) {
			e.printStackTrace();
		}
    	return result;
    }
    
    @GET
    @Path("status-all")
    public String statusAll() {
    	String result = "look at console";
    	try {
			JobOperator operator = BatchRuntime.getJobOperator();
			List<JobInstance> executionIdList = operator.getJobInstances("batchletJob", 0, 4);
			for (JobInstance job : executionIdList) {
				System.out.println(job.getJobName() + job.getInstanceId());				
			}
		} catch (NoSuchJobException | JobExecutionNotRunningException e) {
			result = "No running jobs";
		} catch (JobSecurityException e) {
			e.printStackTrace();
		}
    	return result;
    }

    @GET
    @Path("stop")
    public String stopAll() {
    	String result = "";
    	try {
			JobOperator operator = BatchRuntime.getJobOperator();
			List<Long> executionIdList = operator.getRunningExecutions("chunkJob");
			for (Long executionId : executionIdList) {
				operator.stop(executionId);			
			}
			result = "All stoped";
		} catch (NoSuchJobException | JobExecutionNotRunningException | NoSuchJobExecutionException e) {
			result = "No running jobs";
		} catch (JobSecurityException e) {
			e.printStackTrace();
		}
    	return result;
    }
}
