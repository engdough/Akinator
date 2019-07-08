package br.ufsc.ine5609.Akinator;

import java.util.Scanner;

public class ControlerAkinator {
    Scanner sc = new Scanner(System.in);
    MapeadorAkinator mapeadorAkinator;


    public ControlerAkinator() {
        this.mapeadorAkinator = new MapeadorAkinator();
    }

    public void systemOn() {
        if (mapeadorAkinator.listaVazia()) {
            NodeBinaryTree node = new NodeBinaryTree();
            node.setId(1);
            node.setInfo("Baleia");
            mapeadorAkinator.put(node);
        }

        NodeBinaryTree auxNode = mapeadorAkinator.get("1");
        NodeBinaryTree auxNode1 = mapeadorAkinator.get("1");

        System.out.println("Pense em um animal!");
        System.out.println("Tecle 0 para continuar!");
        int aux = sc.nextInt();
        sc.nextLine();

        if (auxNode.isLeaf()) {
            isLeaf(auxNode);
            mapeadorAkinator.remove(auxNode1);
            mapeadorAkinator.put(auxNode);
        } else {
            notLeaf(auxNode);
            mapeadorAkinator.remove(auxNode1);
            mapeadorAkinator.put(auxNode);
        }

        System.out.println("Fim de jogo, digite 0 para encerrar ou 1 para reiniciar");
        int response = sc.nextInt();
        sc.nextLine();
        if (response == 1) {
            systemOn();
        }
    }

    public void notAnimal(NodeBinaryTree auxNode){
        System.out.println("Qual foi o animal que você pensou?");
        String animal = sc.next();
        sc.nextLine();
        NodeBinaryTree auxNodeY = new NodeBinaryTree();
        auxNodeY.setInfo(auxNode.getInfo());
        auxNode.setNodeYes(auxNodeY);

        NodeBinaryTree auxNodeN = new NodeBinaryTree();
        auxNodeN.setInfo(animal);
        auxNode.setNodeNo(auxNodeN);

        auxNode.setLeaf(false);

        System.out.println("Em que um " + auxNode.getInfo() + " é diferente de um " + animal + "?");
        String question = sc.nextLine();
        auxNode.setInfo(question);
    }

    public void notLeaf(NodeBinaryTree auxNode){
        System.out.println(auxNode.getInfo() + "?");
        System.out.println("Digite 0 para SIM e 1 para NÃO");
        int response = sc.nextInt();
        sc.nextLine();

        if(response == 0 && auxNode.getNodeYes().isLeaf()){
            System.out.println("Você pensou em uma " + auxNode.getNodeYes().getInfo() + "?");
            System.out.println("Digite 0 para SIM ou 1 para NÃO");

            response = sc.nextInt();
            sc.nextLine();

            if(response == 1){
                notAnimal(auxNode.getNodeYes());
            }
        } else if (response == 0 && !auxNode.getNodeYes().isLeaf()){
            notLeaf(auxNode.getNodeYes());
        } else if (response == 1 && auxNode.getNodeNo().isLeaf()){
            isLeaf(auxNode.getNodeNo());
        } else {
            notLeaf(auxNode.getNodeNo());
        }
    }

    public void isLeaf(NodeBinaryTree auxNode){
        System.out.println("Você pensou em uma " + auxNode.getInfo() + "?");
        System.out.println("Digite 0 para SIM ou 1 para NÃO");

        int response = sc.nextInt();
        sc.nextLine();

        if (response == 1) {
            notAnimal(auxNode);
        }

    }
}
