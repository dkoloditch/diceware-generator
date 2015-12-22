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

(defn generate-random-number [] (first (take 1 (repeatedly #(rand-int (count word-list-vector))))))

(defn get-numbers [n] (for [i (range n)] (generate-random-number)))

(defn get-results [n sequence] (for [value sequence] (word-list-vector value)))

(apply str (get-results 5 (get-numbers 5)))