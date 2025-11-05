package requests.skeleton;

import models.BaseModel;

public interface CrudEndpointInterfaces {
    Object post(BaseModel model, String id);
    Object get(String id);
    Object update(BaseModel model, String id);
    Object delete(String id);
}
