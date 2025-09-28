package requests;

import models.BaseModel;

public interface CrudEndpointInterfaces {
    Object post(BaseModel model, Object... params);
    Object get(Object... params);
    Object update(BaseModel model, Object... params);
    Object delete(Object... params);
}
