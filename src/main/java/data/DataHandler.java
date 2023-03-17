package data;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface DataHandler {
    List<FormResponse> transformData() throws GeneralSecurityException, IOException;
}
