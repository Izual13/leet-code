package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@Suppress("ClassName")
class `Implement Trie (Prefix Tree)` {

    @Test
    fun test1() {

        val trie = Trie()
        trie.insert("apple")
        Assertions.assertTrue(trie.search("apple"))
        Assertions.assertFalse(trie.search("app"))
        Assertions.assertTrue(trie.startsWith("app"))
        trie.insert("app")
        Assertions.assertTrue(trie.search("app"))
    }

    class Trie {

        private var isWord: Boolean = false
        private val children = HashMap<Char, Trie>()

        fun insert(word: String) {
            var current = this

            for (char in word) {
                current = current.children.computeIfAbsent(char) { Trie() }
            }

            current.isWord = true
        }

        fun search(word: String): Boolean {
            var current = this

            for (char in word) {
                current = current.children[char] ?: return false

            }

            return current.isWord
        }

        fun startsWith(prefix: String): Boolean {
            var current = this

            for (char in prefix) {
                current = current.children[char] ?: return false
            }
            return true
        }
    }
}