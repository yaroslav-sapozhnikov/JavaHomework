import org.json.JSONObject;

public class OpenWeatherParser extends Weather {

    OpenWeatherParser(String city){
        this.name = "OpenWeather API";
        parse(city);
    }

    public void parse (String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=1f0a000a2de54a0110c5443c52f7819c";
        if (this.parse_successful) {
            JSONObject json = new JSONObject(get_content(url));
            this.last_city = city;
            this.current_weather = json.getJSONArray("weather").getJSONObject(0).getString("main");
            this.feels_like = Math.round(json.getJSONObject("main").getDouble("feels_like")) - 273;
            this.temperature = Math.round(json.getJSONObject("main").getDouble("temp")) - 273;
            this.wind_speed = json.getJSONObject("wind").getInt("speed");
        }
    }
}
