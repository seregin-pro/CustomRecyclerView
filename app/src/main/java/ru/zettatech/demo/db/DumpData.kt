package ru.zettatech.demo.db

import android.database.sqlite.SQLiteDatabase
import ru.zettatech.demo.constant.Constant

class DumpData {
    fun insertData(db: SQLiteDatabase) {
        // Dumping data for table category
        // Columns category_id, parent_id, image, title, description, sort_order, status, date_added. date_modification
        val parent: String =
            "(1, 0, 'animals.png', 'Animals', 'List of Animals', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(2, 0, 'cities.png', 'Cities', 'List of Cities', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(3, 0, 'planets.png', 'Planets', 'List of Planets', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(21, 0, 'countries.png', 'Countries', 'List of Countries', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(22, 0, 'rivers.png', 'Rivers', 'List of Rivers', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(23, 0, 'mountains.png', 'Mountains', 'List of Mountains', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), "

        val child: String =
            "(4, 1, 'cat.png', 'Cat', 'This is very happy cat', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(5, 1, 'dog.png', 'Dog', 'This is smart dog', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(6, 1, 'bear.png', 'Bear', 'The big bear', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(7, 1, 'fish.png', 'Fish', 'The fast fish', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(8, 1, 'spider.png', 'Spider', 'Dangerous spider', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(19, 1, 'horse.png', 'Horse', 'Strong horse', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(20, 1, 'lion.png', 'Lion', 'King of animals', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(24, 1, 'bobcat.png', 'Bobcat', 'Description Bobcat', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(25, 1, 'monkey.png', 'Lion', 'Description Monkey', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(26, 1, 'seal.png', 'Seal', 'Description Seal', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(27, 1, 'lion.png', 'Lion', 'Description Bobcat', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(28, 1, 'lion.png', 'Lion', 'Description Bobcat', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +

            "(9, 2, 'moscow.png', 'Moscow', 'This is Moscow', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(10, 2, 'tokio.png', 'Tokio', 'This is Tokio', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(11, 2, 'minsk.png', 'Minsk', 'This is Minsk', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(12, 2, 'new_york.png', 'New-York', 'This is New-York', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(13, 2, 'london.png', 'London', 'This is London', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +

            "(14, 3, 'earth.png', 'Earth', 'This is Earth', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(15, 3, 'mars.png', 'Mars', 'This is Mars', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(16, 3, 'mercury.png', 'Mercury', 'This is Mercury', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(17, 3, 'venus.png', 'Venus', 'This is Venus', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42'), " +
            "(18, 3, 'uranus.png', 'Uranus', 'This is Uranus', 0, 1, '2024-01-05 21:49:43', '2024-12-20 02:14:42')"


        val sql: String = "INSERT INTO " + Constant.CATEGORY + " (" +
                Constant.CATEGORY_ID + ", " +
                Constant.PARENT_ID + ", " +
                Constant.IMAGE + ", " +
                Constant.TITLE + ", " +
                Constant.DESCRIPTION + ", " +
                Constant.SORT_ORDER + ", " +
                Constant.STATUS + ", " +
                Constant.DATE_ADDED + ", " +
                Constant.DATE_MODIFICATION +
                ")  VALUES " + parent + child

        db.execSQL(sql)
    }
}