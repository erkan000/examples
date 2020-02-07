### Primefaces Samples

This is a very basic Primefaces Sample. It uses jetty.

#### Usage:
- Copy project
- mvn clean package
- mvn jetty:run
- http://localhost:9090/primefaces/autoComplete.jsf
- http://localhost:9090/primefaces/chart.jsf


<f:ajax execute="@this" render="@form" event="keyup"/>

<!-- 
			render="@none" hicbir bilesen etkilenmez
			render="@this" sadece ajax'i cevreleyen
			render="@form" ajax'i iceren form
			render="@all"  tum bilesenler
			
			execute : parametreleri gondermek icin
			 -->
