package example.jmh;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 1)
@Measurement(iterations = 2)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class TestJMH {

	@Benchmark
	public void testStandartForLoop(OrnekData data, Blackhole bh) {
		for (int j = 0; j < data.liste.size(); j++) {
			bh.consume(data.liste.get(j));
		}
	}

	@Benchmark
	public void testForEachLoop(OrnekData data, Blackhole bh) {
		for (String tmp : data.liste) {
			bh.consume(tmp);
		}
	}


	@State(Scope.Benchmark)
	public static class OrnekData {

//		@Param({"1000","9999"})
		@Param({"1000"})
		private int degisken;

		private ArrayList<String> liste = new ArrayList<String>();

		@Setup(Level.Invocation)
		public void setup() {
			for (int i = 0; i < this.degisken; i++) {
				this.liste.add("Eleman:" + i);
			}
		}

	}

}
