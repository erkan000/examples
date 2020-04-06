### JSF (JSR 372: JavaServer Faces (JSF 2.3) Specification) Samples

This is a very basic JSF Sample. It uses maven liberty plug-in

#### Usage:
- Copy project
- mvn clean package
- mvn liberty:dev
- http://localhost:9080/jsf/parameter.jsf
- http://localhost:9080/jsf/dataTable.jsf
- http://localhost:9080/jsf/listeners/actionListener.jsf
- http://localhost:9080/jsf/listeners/valueChangeListener.jsf


<f:ajax execute="@this" render="@form" event="keyup"/>

<!-- 
			render="@none" hicbir bilesen etkilenmez
			render="@this" sadece ajax'i cevreleyen
			render="@form" ajax'i iceren form
			render="@all"  tum bilesenler
			
			execute : parametreleri gondermek icin
			 -->
			 
javax.faces.STATE_SAVING_METHOD : View state'leri sunucu mu yoksa client mı yönetsin? client seçilir ise view expired exception doğal olarak sunucu hiçbir zaman fırlatmaz.
