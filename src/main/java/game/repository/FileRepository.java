package game.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sanver.
 */
public class FileRepository<T extends Serializable> implements Repository<T>  {
    private String fileName;

    public FileRepository(String fileName) {
        this.fileName = fileName;
    }

    private boolean deleteFile(String fileName) {
        return new File(fileName).delete();
    }

    protected void saveAll(List<T> elementList) {
        deleteFile(fileName);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));) {
            for(T element: elementList)
                oos.writeObject(element);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void save(T element) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));) {
            oos.writeObject(element);
        } catch (IOException e) {
        }
    }

    protected List<T> fetchAll() {
        List<T> list = new ArrayList<T>();
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));) {
            Object obj;
            while((obj = inputStream.readObject()) != null) {
                list.add((T) obj);
            }
        } catch (ClassNotFoundException | IOException e) {
        }
        return list;
    }

    protected Set<T> fetchAllIntoSet() {
        Set<T> set = new HashSet<T>();
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));) {
            Object obj;
            while((obj = inputStream.readObject()) != null) {
                set.add((T) obj);
            }
        } catch (ClassNotFoundException | IOException e) {
        }
        return set;
    }
}
