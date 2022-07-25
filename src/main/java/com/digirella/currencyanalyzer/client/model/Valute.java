package com.digirella.currencyanalyzer.client.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Valute")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Valute {

    @XmlElement(name = "Nominal")
    private String nominal;

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Value")
    private String value;

    @XmlAttribute(name = "Code")
    private String code;
}
