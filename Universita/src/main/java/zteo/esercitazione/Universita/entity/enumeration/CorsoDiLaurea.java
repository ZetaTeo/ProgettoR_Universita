package zteo.esercitazione.Universita.entity.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import zteo.esercitazione.Universita.exception.HandleInvalidEnumValue;

public enum CorsoDiLaurea {
    COMPUTER_SCIENCES,
    MATHEMATICAL_SCIENCES


}


//public enum CorsoDiLaurea {
//    DATA_SCIENCE("Scienze e Tecnologie Informatiche"),
//    MATHEMATICAL_SCIENCES("Scienze Matematiche");
//
//    private final String nome;
//
//    CorsoDiLaurea(String nome)
//    {
//        this.nome = nome;
//    }
//
//    @JsonValue
//    public String getNomeCorsoDiLaurea()
//    {
//        return nome;
//    }
//
//    @JsonCreator
//    public static CorsoDiLaurea fromNome(String input)
//    {
//        for(CorsoDiLaurea corso : values())
//        {
//            if(corso.getNomeCorsoDiLaurea().equalsIgnoreCase(input))
//            {
//                return corso;
//            }
//        }
//        throw new HandleInvalidEnumValue(input);
//    }
//}
