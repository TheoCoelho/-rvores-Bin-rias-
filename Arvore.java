
public class Arvore {
    private No raiz;

    private No InserirNovo(No novo, No atual) {
        if (atual == null) return novo;
        if (atual.valor != novo.valor) {
            if (atual.valor > novo.valor)
                atual.esquerda = InserirNovo(novo, atual.esquerda);
            else
                atual.direita = InserirNovo(novo, atual.direita);
        }
        return atual;
    }

    public void inserir(No novo) {
        raiz = InserirNovo(novo, raiz);
    }

    private void preOrdem(No elemento) {
        if (elemento != null) {
            System.out.print(elemento.valor + " ");
            preOrdem(elemento.esquerda);
            preOrdem(elemento.direita);
        }
    }

    public void preOrdem() {
        preOrdem(this.raiz);
    }

    private No encontrarPaiDoElemento(No atual, int valor) {
        if (atual == null) return null;

        if (valor > atual.valor) {
            if (atual.direita != null && atual.direita.valor == valor)
                return atual;
        } else {
            if (atual.esquerda != null && atual.esquerda.valor == valor)
    private void emOrdem(No elemento) {
        if (elemento != null) {
            emOrdem(elemento.esquerda);
            System.out.print(elemento.valor + " ");
            emOrdem(elemento.direita);
        }
    }
                return atual;
    public void emOrdem() {
        emOrdem(this.raiz);
    }
        }

        if (valor > atual.valor)
            return encontrarPaiDoElemento(atual.direita, valor);
        if (valor < atual.valor)
            return encontrarPaiDoElemento(atual.esquerda, valor);

        return null;
    }

    public boolean remover(int valor) {
        if (raiz == null) return false;

        No pai, noX;

        if (raiz.valor == valor) {
            pai = raiz;
            noX = raiz;
        } else {
            pai = encontrarPaiDoElemento(raiz, valor);
            if (pai == null) return false;

            if (pai.valor < valor)
                noX = pai.direita;
            else
                noX = pai.esquerda;
        }

        if (noX.esquerda == null && noX.direita == null) {
            if (pai.valor < valor)
                pai.direita = null;
            else
                pai.esquerda = null;
        }

        else if (noX.esquerda == null || noX.direita == null) {
            No filho = (noX.esquerda != null) ? noX.esquerda : noX.direita;

            if (pai.valor < valor)
                pai.direita = filho;
            else if (pai.valor == valor)
                raiz = filho;
            else
                pai.esquerda = filho;
        }

        else {
            No noPaiDireitaEsquerda = maisEsquerdaPossivel(noX, noX.direita);
            No substituto;

            if (noX.direita.esquerda == null) {
                substituto = noX.direita;
                substituto.esquerda = noX.esquerda;
            } else {
                substituto = noPaiDireitaEsquerda.esquerda;
                noPaiDireitaEsquerda.esquerda = substituto.direita;
                substituto.direita = noX.direita;
                substituto.esquerda = noX.esquerda;
            }

            if (pai.valor < valor)
                pai.direita = substituto;
            else if (pai.valor == valor)
                raiz = substituto;
            else
                pai.esquerda = substituto;
        }

        return true;
    }

    private No maisEsquerdaPossivel(No pai, No atual) {
        if (atual.esquerda == null) return pai;
        return maisEsquerdaPossivel(atual, atual.esquerda);
    }
}
