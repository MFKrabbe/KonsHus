package Hour;

public class Hour
{

        private String id;                  //fldHourID
        private int nr;                      // fldNumberOfHours
        private String cID;                  // fldConsultantID
        private String pID;                  // fldProjektID

        public Hour(){}
        public Hour(String id, int nr, String cID, String pID)
        {
            this.id = id;
            this.nr = nr;
            this.cID = cID;
            this.pID = pID;
        }



        public String getID() {
            return id;
        }


        public void setID(String iD) {
            this.id = iD;
        }


        public int getNr() {
            return nr;
        }


        public void setNr(int nr) {
            this.nr = nr;
        }

        public String getCID() {
            return cID;
        }

        public void setCID(String cID) {
            this.cID = cID;
        }

        public String getPID() {
            return pID;
        }

        public void setPID(String pID) {
            this.pID = pID;
        }
    }

