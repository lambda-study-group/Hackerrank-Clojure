(ns hackerrank.compareTriplets)

(defn compareTriplets [a b]
  (reduce
   (fn [scores pair]
     (let [alice (first pair)
           bob (last pair)]
       (cond
         (< alice bob) (assoc scores 1 (inc (last scores)))
         (> alice bob) (assoc scores 0 (inc (first scores)))
         :else scores)))
   [0 0]
   (map vector a b)))
