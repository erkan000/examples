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

JSF 2.3 ile ManagedBean ler deprecate oldu, View katmanında controller olarak artık CDI Beans leri kullanacağız(Named anotasyonu kullanarak) Ayrıca JSF artifacts , validators, converter, behaviours CDI @Inject kullanılarak inject edilebilir.

private ExternalContext externalContext
private SecurityContext securityContext;
private FacesContext facesContext;
private ServletContext servletContext

#### Micro frontend
JSF'in controller kısmından JAX-RS API nin sağladığı ClientBuilder nesnesi ile restfull servisleri çağırabiliriz. Bu şekilde frontend'i micro frontend 'e çevirebiliriz. Örn;

	Client client = ClientBuilder.newClient();
		WebTarget resource = client
                .target("http://jsonplaceholder.typicode.com")
                .path("users")
                .path("1");
        List<Pojo> rosterList = resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(
                    new GenericType<List<Pojo>>() {
            });
            
Form'dan gelen veriyi PUT metodu ile şöyle yazabiliriz.

	Form form = new Form();
     form.param("name", pojo.getName());
     form.param("number", pojo.getNumber());
            
     Invocation.Builder invocationBuilder = resource.request(MediaType.APPLICATION_XML);
     Response response = invocationBuilder.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), Response.class);

