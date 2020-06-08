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
- http://localhost:9080/jsf/facelets/index.jsf

### Ajax

<f:ajax event=" "	hangi tür eventte ajax request yapılacağı(içindeki komponente göre event türleri değişir)
	    execute=""	hangi komponentlerin JSF execute lifecycle'da işleneği, default olarak hiçbiri işlenmez
	    render=" "	hangi komponentlerin JSF render lifecycle'da işleneği, default olarak hiçbiri işlenmez
		/>

Burada komponentler aralarında boşluk ayrılarak listelenir.

Events;
- HTML standart DOM events (focus, blur, keydown, mouseover, click)
- ActionSource components, action
- EditableValueHolder components, value

Render;
- "@none" hicbir bilesen etkilenmez
- "@this" sadece ajax'i cevreleyen komponentin kendisi (Default)
- "@form" ajax'i iceren form
- "@all"  tum bilesenler
			 
f:ajax diğer özellikleri
- listener		attach a server-side event listener
- onevent		attach a client-side event listener
- onerror		attach a client-side error handler

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

