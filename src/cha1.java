public class cha1 {

    enum measure {
        m, cm, mm;

        public float GetMetter(float nb) {

            switch (this) {
                case m:
                    break;
                case cm:
                    nb = nb / 100;
                    break;
                case mm:
                    nb = nb / 1000;
                    break;
                default:
                    break;
            }
            return nb;

        }
    }

    float calc = measure.m.GetMetter(100) * measure.mm.GetMetter(20);

    public void getResult() {
        System.out.println(calc + "m²");
    }

}
