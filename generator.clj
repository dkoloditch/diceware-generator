(require '[clojure.set :as set])

(defn get-line-from-file [number]
  (with-open [wordlist (clojure.java.io/reader "wordlist.txt")] 
    (doall
      (for [line (line-seq wordlist) :when (re-seq (re-pattern number) line)]
        (apply str line)
      )
    )
  )
)

(defn get-match [n]
  (re-seq 
    #"\b()[a-z]+|\d{1,4}$|([0-9]{1,4}(th|rd|st))$|[\!\@\#\$\%\^\&\*\(\)\-\_\=\+\;\:\?]{1,2}$" 
    (apply str (get-line-from-file n))
  )
)

(defn generate-random-numbers [n]
  (vec
    (let [a-set (set (take n (repeatedly #(rand-int 666666))))] a-set)
  )
)