package EstructurasDeDatos;

public class RevisorParentesis<T> {
    private String analize;


    public RevisorParentesis() {

    }
    public RevisorParentesis(String ana){
        analize = ana;
    }

    public boolean analizarParentesis() {
        boolean resp = true;

        PilaA<Character> parentesis = new PilaA<Character>();
        int i = 0;

        while (i<analize.length() && resp) {
            if (analize.charAt(i) == '(') {
                parentesis.push(analize.charAt(i));
            }
            else if(analize.charAt(i) == ')') {
                try {
                    parentesis.pop(); // elimino si hay parentesis que eliminar
                }catch(Exception e){
                    resp = false; // esto se da porque trate de eliminar datos y mi pila estaba vacia
                }
            }
            i++;
        }
        // que no trate de eliminar cosas que no habia y que la pila se quedo sin datos porque los parentesis balanceados
       resp = resp && parentesis.isEmpty();

        return resp;
    }
}
