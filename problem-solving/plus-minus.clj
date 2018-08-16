(defn update [coll k f]
  (assoc coll k (f (get coll k))))

(defn plusMinus
  ([arr] (plusMinus arr (count arr)))
  ([arr n] (->>
            (reduce (fn [tally x]
                      (cond (pos? x) (update tally 0 inc)
                            (neg? x) (update tally 1 inc)
                            :else (update tally 2 inc)))
                    [0 0 0]
                    arr)
            (map #(/ % n)))))


;; (def n (Integer/parseInt (clojure.string/trim (read-line))))

;; (def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

;; (plusMinus arr)
;; (print (clojure.string/join "\n" (map (comp str float) (plusMinus arr))))
