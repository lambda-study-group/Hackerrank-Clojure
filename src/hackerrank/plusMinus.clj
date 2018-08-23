(ns hackerrank.plusMinus)

(def arr [-4 3 -9 0 4 1])

(defn update [m k f]
  (assoc m k (f (get m k))))

(defn pm [arr]
  (let [len (count arr)]
    (map #(-> % (/ len) float str)
         (loop [acc [0 0 0]
                c 0]
           (if (= c len)
             acc
             (recur (cond
                      (< 0 (nth arr c)) (update acc 0 inc)
                      (> 0 (nth arr c)) (update acc 1 inc)
                      (zero? (nth arr c)) (update acc 2 inc))
                    (inc c)))))))

(defn plusMinus [n] (println (clojure.string/join "\n"
                                                  (pm n))))

(plusMinus arr)
