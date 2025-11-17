package fr.groupe.pcube;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "test_entity")
public class TestEntity {

    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "int_value")
    private int intValue;

    @Column(name = "long_value")
    private long longValue;

    @Column(name = "text_value")
    private String textValue;

    public TestEntity(){}
    
    public TestEntity(int intValue, long longValue, String textValue) {
        this.id = UUID.randomUUID();
        this.intValue = intValue;
        this.longValue = longValue;
        this.textValue = textValue;
    }

    public UUID getId() {
        return id;
    }

    public int getIntValue() {
        return intValue;
    }

    public long getLongValue() {
        return longValue;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public void setLongValue(long longValue) {
        this.longValue = longValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    @Override
    public String toString() {
        return "TestEntity [id=" + id + ", intValue=" + intValue + ", longValue=" + longValue + ", textValue="
                + textValue + "]";
    }

    
}
