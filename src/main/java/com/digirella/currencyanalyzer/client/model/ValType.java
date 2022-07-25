package com.digirella.currencyanalyzer.client.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "ValType")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class ValType {

    @XmlElement(name="Valute")
    private List<Valute> valute;

    @XmlAttribute(name = "Type")
    private String type;
}
