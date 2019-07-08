package br.ufsc.ine5609.Akinator;

import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

public class MapeadorAkinator {

    private HashMap<String, NodeBinaryTree> cacheNodeBinaryTree = new HashMap<>();
    private final String filename = "akinator.dados";

    public MapeadorAkinator(){
        load();
    }

    public NodeBinaryTree get(String codigo){
        return cacheNodeBinaryTree.get(codigo);
    }

    public void put (NodeBinaryTree nodeBinaryTree){
        cacheNodeBinaryTree.put(Integer.toString(nodeBinaryTree.getId()), nodeBinaryTree);
        persist();
    }

    public void persist(){
        try{
            FileOutputStream fileOutput = new FileOutputStream(filename);

            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(cacheNodeBinaryTree);

            objectOutput.flush();
            fileOutput.flush();

            objectOutput.close();
            fileOutput.close();
        } catch (FileNotFoundException ex){
            System.out.println("ARQUIVO NÃO ENCONTRADO");
        } catch (IOException ex){
            System.out.println("ERRO AO ABRIR O ARQUIVO");
        }
    }

    public void load(){
        try {
            FileInputStream fileInput = new FileInputStream(filename);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);

            this.cacheNodeBinaryTree = (HashMap<String, NodeBinaryTree>) objectInput.readObject();

            objectInput.close();
            fileInput.close();
        } catch (ClassNotFoundException ex){
            System.out.println("ERRO AO ABRIR O ARQUIVO");
        } catch (FileNotFoundException ex){
            System.out.println("ARQUIVO NÃO ENCONTRADO");
            persist();
        } catch (IOException ex){
            System.out.println("ERRO AO ABRIR O ARQUIVO");
        }
    }

    public Collection<NodeBinaryTree> getList(){
        return cacheNodeBinaryTree.values();
    }

    public void remove(NodeBinaryTree nodeBinaryTree){
        cacheNodeBinaryTree.remove(Integer.toString(nodeBinaryTree.getId()));
        persist();
    }

    public boolean listaVazia(){
        return cacheNodeBinaryTree.isEmpty();
    }

    public int tamanhoLista(){
        return cacheNodeBinaryTree.size();
    }
}
