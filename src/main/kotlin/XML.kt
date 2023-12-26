
import org.w3c.dom.Element
import java.io.BufferedReader
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory


class XML {
    fun readXml(path: String): List<Building> {
        var inputStream = File(path).inputStream()

        val list= emptyList<Building>().toMutableList()
        val builderFactory = DocumentBuilderFactory.newInstance()
        val docBuilder = builderFactory.newDocumentBuilder()

        val doc = docBuilder.parse(inputStream)
        val Addresses=doc.getElementsByTagName("item")


        for(i in 0 until  Addresses.length){
            val building=Addresses.item(i) as Element
            list.add(Building(building.getAttribute("city"),building.getAttribute("street"),building.getAttribute("house").toInt(),building.getAttribute("floor").toInt()))
        }
        return list
    }

}