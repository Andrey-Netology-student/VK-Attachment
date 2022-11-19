object WallService { //Объект WallService, который хранит посты в массиве.
    private var posts = emptyArray<Post>() //Переменная с пустым массивом для хранения постов
    private var nextId = 0 //Для нумерации постов в массиве

    fun add(post: Post): Post { //Функция для добавления постов в массив posts
        posts += post.copy(id = ++nextId) //Добавляет в массив posts новый пост, присваивает ему id
        return posts.last() //Возвращает последний элемент массива posts
    }
    fun update(postUp: Post): Boolean {
        var result = false
        for ((index, post) in posts.withIndex()) { //Перебор постов по индексу (for each)
            if (post.id == postUp.id) { //Сравнение id поста с id нового, переданного в функцию поста
                posts[index] = postUp.copy() //Результат копии нового поста записывается в массив
                result = true
            }
        }
        return result
    }
    fun printAll() {
        for (post in posts) {
            println(post)
        }
        println()
    }
    fun clear() {
        posts = emptyArray() //Очищает массив
        nextId = 0 //Сбрасывает счётчик
    }
}