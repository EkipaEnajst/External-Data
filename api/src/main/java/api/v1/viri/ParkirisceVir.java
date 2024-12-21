package api.v1.viri;

import org.ekipaenajst.beans.ParkiriscaZrno;
import org.ekipaenajst.entitete.Parkirisce;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("parkirisca")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ParkirisceVir {
    @Inject
    ParkiriscaZrno parkiriscaZrno;

    @GET
    @Path("{id}") // DODAJ ID PARAMETER
    public Response vrniParkirisce(@PathParam("id") int id) throws IOException, InterruptedException {
        Parkirisce p = parkiriscaZrno.getParkirisce(id);

        return Response.status(Response.Status.OK).entity(p).build();


    }
}
