package api.v1.viri;

import org.ekipaenajst.beans.ParkiriscaZrno;
import org.ekipaenajst.entitete.Parkirisce;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("parkirisca")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ParkirisceVir {
    @Inject
    ParkiriscaZrno parkiriscaZrno;

    @GET
    public Response vrniParkirisca() throws IOException, InterruptedException {
        List<Parkirisce> pl = parkiriscaZrno.getParkirisca();

        return Response.status(Response.Status.OK).entity(pl).build();
    }

    @GET
    @Path("{id}") // DODAJ ID PARAMETER
    public Response vrniParkirisce(@PathParam("id") int id) throws IOException, InterruptedException {
        Parkirisce p = parkiriscaZrno.getParkirisce(id);

        if (p==null) return Response.status(Response.Status.NOT_FOUND).build();

        return Response.status(Response.Status.OK).entity(p).build();


    }

    //@RolesAllowed("admin") // TODO POGLEJ KAKO SE UPORABLJA TE ANOTACIJE
    @POST
    public Response dodajParkirisce(Parkirisce p) throws IOException, InterruptedException {
        parkiriscaZrno.createParkirisce(p);
        return Response.status(Response.Status.CREATED).entity(p).build();
    }
}
