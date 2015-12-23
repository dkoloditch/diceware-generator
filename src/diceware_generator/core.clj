(ns diceware-generator.core (:gen-class))

(defn -main []

  (defn get-word-list-from-file []
    (with-open [wordlist (clojure.java.io/reader "wordlist.txt")] 
      (doall
        (for [line (line-seq wordlist)]
          (apply str line)
        )
      )
    )
  )

  (def word-list-vector (vec (get-word-list-from-file)))

  (defn generate-random-number [] 
    (first (take 1 (repeatedly #(rand-int (count word-list-vector)))))
  )

  (defn get-numbers [n] (for [i (range n)] (generate-random-number)))

  (defn get-results [n sequence] (for [value sequence] (word-list-vector value)))

  (println "----------------------------------------------")
  (println "             Diceware Generator               ")
  (println "----------------------------------------------")
  (println "")
  (println "How many words? A minimum of six is suggested.")
  (def user-input (Integer. (read-line)))
  (def results (get-results user-input (get-numbers user-input)))
  (println "")
  (println (clojure.string/join " " results))
  (println (apply str results))
  (println "")

)
