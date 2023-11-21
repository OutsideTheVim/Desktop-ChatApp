import kotlin.random.Random

class ChatViewModel {

    fun getRandomUsername(): String {

        val length: Int = 8

        var allChars = listOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z') // moet tot Z
        var randomNumbers = List(length + 1) { Random.nextInt(0, allChars.size) }

        var username: String = ""

        for(i in 1..length) {
            username += allChars[randomNumbers[i]]
        }

        return username

    }


}