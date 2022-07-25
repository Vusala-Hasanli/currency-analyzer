package com.digirella.currencyanalyzer.client.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class ValCurs {

    @XmlElement(name="ValType")
    private List<ValType> valType;

    @XmlAttribute(name="Date")
    private String date;

}
