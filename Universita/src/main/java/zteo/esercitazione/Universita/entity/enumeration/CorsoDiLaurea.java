package zteo.esercitazione.Universita.entity.enumeration;

import zteo.esercitazione.Universita.exception.HandleInvalidEnumValue;

public enum CorsoDiLaurea {
    DATA_SCIENCE("Scienze e Tecnologie Informatiche"),
    MATHEMATICAL_SCIENCES("Scienze Matematiche");

    private final String nome;

    CorsoDiLaurea(String nome)
    {
        this.nome = nome;
    }

    public String getNomeCorsoDiLaurea()
    {
        return nome;
    }

    public static CorsoDiLaurea fromNome(String input)
    {
        for(CorsoDiLaurea corso : values())
        {
            if(corso.getNomeCorsoDiLaurea().equalsIgnoreCase(input))
            {
                return corso;
            }
        }
        throw new HandleInvalidEnumValue(input);
    }
}
