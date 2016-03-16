package com.unipe.barros.studio.orh.models;

import java.util.List;

/**
 * @author shark74
 *
 */
public class PaginatedList {

   private List<?> currentList;
   private final Number count;

   public PaginatedList(List<?> currentList, Number count) {
      this.currentList = currentList;
      this.count = count;
   }

   public List<?> getCurrentList() {
      return currentList;
   }

   public int getCount() {
      return count.intValue();
   }

   public int getNumberOfPages(int perPage) {
      int total = getCount();
      int pages = total / perPage;

      if (total % perPage > 0) {
         pages++;
      }
      return pages == 0 ? 1 : pages;
   }

}