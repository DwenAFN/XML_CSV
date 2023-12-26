import java.io.File
import java.io.FileInputStream
import java.io.InputStream

class CSV {
    fun readCsv(path: String): List<Building> {
        var inputStream = File(path).inputStream()
        val reader = inputStream.bufferedReader()
        val header = reader.readLine()

        return reader.lineSequence()
            .filter { it.isNotBlank() }
            .map {
                val (city,street,house,floor) = it.split(';', ignoreCase = false, limit = 4)
                Building(city.trim('"'),street.trim('"'),house.trim().toInt(),floor.trim().removeSurrounding("\"").toInt())
            }.toList()
    }

}