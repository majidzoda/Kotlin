import sun.jvm.hotspot.code.NMethod
// Challenge: Enhancing the Aura p.42
fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()

    // Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"

    val healthStatus = when (healthPoints){
        100 -> " is in excellent condition!"
        in 90..99 -> " has a few scratches"
        in 75..89 -> if (isBlessed){
            " has some minor woulds but is healing quite quickly"
        } else {
            " has a some minor wounds"
        }
        in  15..74 -> " looks pretty hurt"
        else ->  " is in awful condition!"
    }


    // Player status
    println("(Aura: ${when (karma){
        in 0..5 -> "red"
        in 6..10 -> "orange"
        in 11..15 -> "purple"
        in 11..20 -> "green"
        else -> "NONE"
    }
    }) " + "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}