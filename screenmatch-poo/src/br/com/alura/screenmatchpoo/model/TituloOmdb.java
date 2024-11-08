package br.com.alura.screenmatchpoo.model;

/*
O Record serve para fazer um de-para dos campos que estão vindo do sistema terceiro. Nesse caso foi criado um record
chamado 'TituloOmdb', porém se tivessem mais sistemas de origem, poderiam ser criados N records, ou seja, um para
cada sistema de origem.

O record também é considerado como uma classe imutável, ou seja, depois de instanciado não pode ter seus atributos
alterados.
 */
public record TituloOmdb(String title, String year, String runtime) {
}
