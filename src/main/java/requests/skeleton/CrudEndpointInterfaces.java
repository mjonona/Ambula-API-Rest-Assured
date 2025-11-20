package requests.skeleton;

import models.BaseModel;

public interface CrudEndpointInterfaces {
    Object post(String medicalCenterID, BaseModel model, String... id);
    Object get(String medicalCenterID, String id);
    Object update(String medicalCenterID, BaseModel model, String... id);
    Object patch(String medicalCenterID, BaseModel model, String id);
    Object delete(String medicalCenterID, String id);
}
