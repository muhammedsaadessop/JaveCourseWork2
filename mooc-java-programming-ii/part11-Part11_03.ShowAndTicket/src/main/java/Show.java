public class Show {
    private String movie;
    private String time;

    public Show(String movie, String time) {
        this.movie = movie;
        this.time = time;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Show{movie='" + movie + "', time='" + time + "'}";
    }
}
