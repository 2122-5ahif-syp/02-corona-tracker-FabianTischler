package at.htl.boundary;

import at.htl.control.PersonRepository;
import at.htl.entities.Person;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("person")
public class PersonEndpoint {
    @Inject
    PersonRepository personRepository;

    @POST
    @Path("/add")
    public Response addPerson(Person person, @Context UriInfo info){
        final Person savedPerson = personRepository.save(person);
        URI uri = info.getAbsolutePathBuilder().path("/person/add/" + savedPerson.getPersonId()).build();
        return Response.created(uri).build();
    }
}
