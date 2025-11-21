#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
module ${package} {
    requires javafx.controls;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    opens ${package} to org.hibernate.orm.core;
    exports ${package};
}
