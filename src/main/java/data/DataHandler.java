package data;

import domain.Child;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface DataHandler {
    List<Child> transformData() throws GeneralSecurityException, IOException;
}
