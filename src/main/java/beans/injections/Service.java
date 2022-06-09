package beans.injections;

import beans.injections.ii.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Service {

    @Autowired
    @Qualifier ("oracleRepository")
    Repository repository1;

    @Autowired
    @Qualifier ("mySqlRepository")
    Repository repository2;




}
