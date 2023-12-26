import java.io.InputStream
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class Interface {
    //C:\Users\artem\Documents\address.csv
    //C:\Users\artem\Documents\address.xml
    fun Show():Boolean{
        println("Enter file path (To stop enter 'stop')")
        val path= readln()
        val type=path.split('.').last()
        try {
            when (type) {
                "csv" -> {
                    val csv = CSV()
                    val time = measureTime {
                        var list = csv.readCsv(path).toMutableList()
                        var map = HashMap<Building, Int>()
                        findDupes(list, map)
                        printDupes(map)
                        val floors = floorsCount(list)
                        printFloorsStats(floors)
                    }
                    println("Time:" + time)
                    return false

                }

                "xml" -> {
                    val time = measureTime {
                        val xml = XML()
                        var list = xml.readXml(path).toMutableList()
                        var map = HashMap<Building, Int>()
                        findDupes(list, map)

                        printDupes(map)
                        val floors = floorsCount(list)
                        printFloorsStats(floors)
                    }
                    println("Time:" + time)
                    return false
                }

                "stop" -> return true
                else -> {
                    println("Wrong path or file type.")
                    return false
                }
            }
        }
        catch (e:Exception){
            println(e.message)
            return false
        }

    }
    fun findDupes(list:MutableList<Building>,map:HashMap<Building,Int>){
        var addressIterator =list.iterator()
        while (addressIterator.hasNext()){
            val address = addressIterator.next()
            var count=map.get(address)
            map.put(address,if(count==null) 1 else (count+1))
            if(count != null){
                addressIterator.remove()
            }
        }

    }
    fun printDupes(map:HashMap<Building,Int>){
        println("Duplicates")
        val new_map= map.filterValues { it>=2 } as HashMap<Building, Int>
        new_map.forEach{(key,value)->println("${key.city}, ${key.street}, ${key.house}, Этажей: ${key.floors} | $value")}
        println()
    }
    fun floorsCount(list:List<Building>):HashMap<String,Array<Int>>{
        var floorsMap=HashMap<String,Array<Int>>()
        for(address in list){
            var floors=floorsMap.get(address.city)
            if(floors==null){
                floors= Array<Int>(5) { 0 }
            }
            floors[address.floors-1]+=1
            floorsMap.put(address.city,floors)

        }
        return floorsMap
    }
    fun printFloorsStats(map:HashMap<String,Array<Int>>){
        println("Floor statistics by City")
        map.forEach{(key,value)->println("${key.padStart(20)}, Этажей:  ${value.joinToString(" ")}")}
    }
}