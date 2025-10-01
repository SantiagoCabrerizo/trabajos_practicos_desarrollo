package Iterator;

public class ListaCursosIterator implements CursoIterator{
    private java.util.List<Curso> cursos;
    private int posicion = 0;

    public ListaCursosIterator(java.util.List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public boolean hasNext() {
        return posicion < cursos.size();
    }

    @Override
    public Curso next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException("No hay más cursos.");
        }
        return cursos.get(posicion++);
    }
}
