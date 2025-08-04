
public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(15);
        arvore.inserir(3);
        arvore.inserir(7);

        System.out.println("Caminhamento em ordem:");
        arvore.emOrdem();
        System.out.println("Pré-Ordem:");
        arvore.preOrdem(); 

        System.out.println("\n\nRemovendo folha (nó 3):");
        arvore.remover(3);
        arvore.preOrdem();  
        System.out.println("\n\nRemovendo nó com 1 filho (nó 15):");
        arvore.remover(15);
        arvore.preOrdem();  
        System.out.println("\n\nRemovendo nó com 2 filhos (nó 10):");
        arvore.remover(10);
        arvore.preOrdem();  
}
