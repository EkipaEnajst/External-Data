package api.v1.viri;

import org.ekipaenajst.beans.UporabnikiZrno;
import org.ekipaenajst.beans.ZasedenostZrno;
import org.ekipaenajst.entitete.Uporabnik;
import org.ekipaenajst.entitete.Zasedenost;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("zasedenosti")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ZasedenostVir {
    @Inject
    private ZasedenostZrno zasedenostZrno;

    @GET
    public Response vrniZasedenosti() throws IOException, InterruptedException {

        List<Zasedenost> zasedenosti = zasedenostZrno.getZasedenosti();

        return Response.status(Response.Status.OK).entity(zasedenosti).build();
    }
}


