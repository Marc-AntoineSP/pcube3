module fr.groupe.pcube {
    requires javafx.controls;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    opens fr.groupe.pcube to org.hibernate.orm.core;
    exports fr.groupe.pcube;
}
