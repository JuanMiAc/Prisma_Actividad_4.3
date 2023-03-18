
package areaprisma2;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;

public class Prisma {
    private int baseTriangulo;
    private int alturaPrisma;
    
     /** 
     * Aquí generamos los atributos del triángulo.
     * @param baseTriangulo es la base.
     * @param alturaPrisma es la altura.
     */
    public Prisma(int baseTriangulo, int alturaPrisma) {
        this.baseTriangulo = baseTriangulo;
        this.alturaPrisma = alturaPrisma;
  
    }
         /**
         * En este metodo get obtenemos el valor de la base del triángulo
         * @return nos da le valor de la base del triángulo.
         */
    public int getBaseTriangulo() {
        return baseTriangulo;
    }
         /**En este metodo le damos el valor a la base del triángulo
         *@param baseTriangulo es el valor de la base del triángulo.
         */
    public void setBaseTriangulo(int baseTriangulo) {
        this.baseTriangulo = baseTriangulo;
    }
       /**
       * En este metodo get obtenemos el valor de  la altura del prisma
       * @return nos devuelve el valor de la altura del prisma. 
       */
    public int getAlturaPrisma() {
        return alturaPrisma;
    }
        /**
         *En este metodo le damos el valor a la altura del prisma
         *@param alturaPrisma es el valor de la altura del prisma.
         */  
    public void setAlturaPrisma(int alturaPrisma) {    
        this.alturaPrisma = alturaPrisma;
    }
        /**
        *En este metodo calculamos la altura del triángulo
        *@return nos devuelve la altura del triángulo.
        **/
    public float alturaTriangulo() {
        return (float) (baseTriangulo * Math.sqrt(3) / 2);
    }
        /**
        *En este metodo hacemos el cálculo de el area del triángulogulo
        *@return nos devuelve el valor del area de la base.
        **/
    public float areaBase() {
        return baseTriangulo * alturaTriangulo();
    }
         /**
         *En este metodo calculamos el perímetro del triángulo
         *@return nos devuelve el valor del perímetro.
         */
    public float perimetro() {
        return 3 * baseTriangulo;
    }
     /**En este metodo hayamos el area del lateral
         *@return nos devuelve el perímetro.
         */
    public float areaLateral() {
        return perimetro() * alturaPrisma;
    }
         /**En este metodo obtenemos el total de area del prisma
         *@return nos devuelve el area total.
         */
    public float areaTotal() {
        return 2 * areaBase() + areaLateral();
    }
        
    public static void main(String[] args) {
        ArrayList<Prisma> prismas = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            int base = (int) (Math.random() * 10 + 1); 
            int altura = (int) (Math.random() * 10 + 1); 
            Prisma prisma = new Prisma(base, altura);
            prismas.add(prisma);
        }     
       
        for (Prisma prisma : prismas) {
            float area = prisma.areaTotal();
            imprimirValor("El área total del prisma con base " + prisma.getBaseTriangulo() + " y altura " 
                + prisma.getAlturaPrisma() + " es: " + area);
        }
        
        Collections.sort(prismas, (p1, p2) -> Float.compare(p2.areaTotal(), p1.areaTotal()));
        
        String prismsSortedByArea = "Prismas ordenados de mayor a menor área:\n";
        for (Prisma prisma : prismas) {
            prismsSortedByArea += "Base: " + prisma.getBaseTriangulo() + ", altura: " + prisma.getAlturaPrisma() 
                + ", área total: " + prisma.areaTotal() + "\n";
        }
        imprimirValor(prismsSortedByArea);
    }
        /**
         *En este metodo mostramos los datos por mensaje de dialogo
         * @param valor nos imprime el valor
         */
    public static void imprimirValor(String valor) {
        JOptionPane.showMessageDialog(null, valor);
    }
}

