/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_fabricante_equipamento.n.MODEL;

/**
 *
 * @author vitor
 */
public class Fabricante {   
    private int idFabricante;
    private String nome;
    private String cnpj;
    private String cidade;
    private String estado;

    public Fabricante(String nome, String cnpj, String cidade, String estado) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.estado = estado;
    }
    
    

    public Fabricante(int idFabricante, String nome, String cnpj, String cidade, String estado) {
        this.idFabricante = idFabricante;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.estado = estado;
    }

    

    public int getIdFabricante() {
        return idFabricante;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
    @Override
    public String toString(){
        return this.nome;
    }
}
