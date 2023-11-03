/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_fabricante_equipamento.n.MODEL;

/**
 *
 * @author vitor
 */
public class Equipamento {
    private int idEquipamento;
    private int idFabricante;
    private String nome;
    private float preco;

    public Equipamento(int idFabricante, String nome, float preco) {
        this.idFabricante = idFabricante;
        this.nome = nome;
        this.preco = preco;
    }
    
    

    public Equipamento(int idEquipamento, int idFabricante, String nome, float preco) {
        this.idEquipamento = idEquipamento;
        this.idFabricante = idFabricante;
        this.nome = nome;
        this.preco = preco;
    }
 
    public int getIdEquipamento() {
        return idEquipamento;
    }

    public int getIdFabricante() {
        return idFabricante;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }
    
    
    
}
